import java.util.*;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		String test = "A,B,C,D,E;0,2,4,5,8;3,6,4,5,2";
		System.out.println(Scheduler_FCFS(test));
		System.out.println(Scheduler_SJF(test));
		System.out.println(Scheduler_RR(test));
		System.out.println();
		String test2 = "Hi,Bye;0,0;4,2";
		System.out.println(Scheduler_FCFS(test2));
		System.out.println(Scheduler_SJF(test2));
		System.out.println(Scheduler_RR(test2));


	}

	public static String Scheduler_FCFS(String input) {
		Queue<String> processesQ = new LinkedList<>();
		String processes = "";
		String executionStr = "";
		String[] array = new String[2];
		String result = "";
		int processesSize;
		array = input.split(";");

		// handling the processes

		processes = array[0];
		processesSize = processes.length();
		String[] processesA = new String[(processesSize / 2) + 1];
		processesA = processes.split(",");

		for (int i = 0; i < processesA.length; i++)
			processesQ.add(processesA[i]);

		// handling the arrival Time

	
		// handling the execution time

		executionStr = array[2];
		String[] executionA = new String[(executionStr.length() / 2) + 1];
		executionA = executionStr.split(",");

		int i = 0;
		while (!processesQ.isEmpty()) {
			result += processesQ.poll();
			result += '(';
			result += executionA[i];
			result += ')';
			if (!processesQ.isEmpty())
				result += ',';
			i++;
		}

		return result;
	}

	//

	public static String Scheduler_SJF(String input) {
		String processes = "";
		String arrivalTimeStr = "";
		String executionStr = "";
		String[] array = new String[2];
		String result = "";
		int currentTime = 0;
		int min = 999999999;
		int number_of_pro;

		array = input.split(";");

		// handling the processes

		processes = array[0];
		String[] processesA = new String[(processes.length() / 2) + 1];
		processesA = processes.split(",");
		number_of_pro = processesA.length;

		// handling the arrival Time

		arrivalTimeStr = array[1];
		String[] arrivalTimeAstr = new String[(arrivalTimeStr.length() / 2) + 1];
		arrivalTimeAstr = arrivalTimeStr.split(",");
		int[] arrivalTimeNum = new int[arrivalTimeAstr.length];
		for (int i = 0; i < arrivalTimeAstr.length; i++)
			arrivalTimeNum[i] = Integer.parseInt(arrivalTimeAstr[i]);

		// handling the execution time

		executionStr = array[2];
		String[] executionAstr = new String[(executionStr.length() / 2) + 1];
		executionAstr = executionStr.split(",");
		int[] executionNum = new int[executionAstr.length];
		for (int i = 0; i < executionNum.length; i++)
			executionNum[i] = Integer.parseInt(executionAstr[i]);

		int[] torf = new int[number_of_pro];
		for (int i = 0; i < torf.length; i++)
			torf[i] = 0;

		int pos = 0;
		int total = 0;
		boolean flag;

		while (true) {

			flag = false;
			min = Integer.MAX_VALUE;
			pos = 0;

			if (total == number_of_pro)
				break;

			for (int k = 0; k < number_of_pro; k++) {

				if (arrivalTimeNum[k] <= currentTime && torf[k] == 0) {
					if (executionNum[k] <= min) {
						min = executionNum[k];

						// System.out.println(min);

						pos = k;
						flag = true;
					}
				}
			}

//           System.out.println(min);

			if (flag) {
				torf[pos] = 1;
				result += processesA[pos];
				result += '(';
				result += executionNum[pos];
				result += "),";
				currentTime += executionNum[pos];
				total++;
			} else
				currentTime++;

		}

		result = result.substring(0, result.length() - 1);

		return result;

	}

	public static String Scheduler_RR(String input) {

		String processes = "";
		String arrivalTimeStr = "";
		String executionStr = "";
		String[] array = new String[2];
		String result = "";
		int currentTime = 0;
		int number_of_pro;
		int total = 0;

		array = input.split(";");

		// handling the processes

		processes = array[0];
		String[] processesA = new String[(processes.length() / 2) + 1];
		processesA = processes.split(",");
		number_of_pro = processesA.length;

		// handling the arrival Time

		arrivalTimeStr = array[1];
		String[] arrivalTimeAstr = new String[(arrivalTimeStr.length() / 2) + 1];
		arrivalTimeAstr = arrivalTimeStr.split(",");
		int[] arrivalTimeNum = new int[arrivalTimeAstr.length];
		for (int i = 0; i < arrivalTimeAstr.length; i++)
			arrivalTimeNum[i] = Integer.parseInt(arrivalTimeAstr[i]);

		// handling the execution time

		executionStr = array[2];
		String[] executionAstr = new String[(executionStr.length() / 2) + 1];
		executionAstr = executionStr.split(",");
		int[] executionNum = new int[executionAstr.length];
		for (int i = 0; i < executionNum.length; i++) 
			executionNum[i] = Integer.parseInt(executionAstr[i]);
		
		int[] torf = new int[number_of_pro];
		for (int i = 0; i < torf.length; i++)
			torf[i] = 0;

		
		Queue<Integer> processesQ = new LinkedList<>();
        Queue<Integer> processesQTemp = new LinkedList<>();
        
		
		
while(total != number_of_pro) {
			
			
		for(int i = 0; i < processesA.length; i++) {
			if(arrivalTimeNum[i] <= currentTime && arrivalTimeNum[i] != -1 && torf[i] != -1) {
						processesQ.add(i);//passing the index
						torf[i] = -1;	//so that we dont pass on it again
						//torf = addX(i,torf,-1);
				}
			
			}
		  while (!processesQTemp.isEmpty())
			  	processesQ.add(processesQTemp.remove());
		  
		
		  	if(!processesQ.isEmpty()) {
			  
			for(int y = 0; y < processesQ.size(); y++) {
				int temp = processesQ.poll();
				
				if(executionNum[temp] - 2 < 0) {
					executionNum[temp] = -1; 
					arrivalTimeNum[temp] = -1;
					result += "" + processesA[temp] + "(1),";
				//	currentTime += 2;
					total++;
					currentTime += 1;
					//bubbleSort(torf);
				}
				else if(executionNum[temp] - 2 == 0) {
					executionNum[temp] = -1;
					arrivalTimeNum[temp] = -1;
					result += "" + processesA[temp] + "(2),";
				//	currentTime += 2;
					total++;
					currentTime += 2;
					//bubbleSort(torf);

				}
				else if(executionNum[temp] - 2 > 0){
					executionNum[temp] -= 2;
					result += "" + processesA[temp] + "(2),";
					//currentTime += 2;
					processesQTemp.add(temp);
					currentTime += 2;
					//bubbleSort(torf);
				}
				
					
				
			 }
		  }
		  	else
		  		currentTime += 1;
	
		}
		
		//System.out.println(currentTime);
		
			result = result.substring(0, result.length() - 1);

		return result;	

	}
	
	
	public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
 
    public static   void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static int[] removeTheElement(int[] arr, int index){
 
   
        if (arr == null
            || index < 0
            || index >= arr.length) {
 
            return arr;
        }
 
        // return the resultant array
        return IntStream.range(0, arr.length)
            .filter(i -> i != index)
            .map(i -> arr[i])
            .toArray();
    }
    public static int[] addX(int n, int arr[], int x)
    {
        int i;
  
        int newarr[] = new int[n + 1];
  
  
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
    }
    
	
}