import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    int myNums[] = { 2, 5, 1, 20, 11, 7 };

    System.out.println("Orignal " + Arrays.toString(myNums));
    System.out.println();

    // int sortedNums[] = bubbleSort(myNums);
    // int sortedNums[] = insertionSort(myNums);
    // int sortedNums[] = selectionSort(myNums);
    // int sortedNums[] = quickSort(myNums);
    // int sortedNums[] = mergeSorter(myNums);
    int sortedNums[] = gnomeSorter(myNums);

    System.out.println("Sorted " + Arrays.toString(sortedNums));

  }

  public static int[] bubbleSort(int nums[]) {
    int arrLen = nums.length;
    // System.out.println(arrLen);
    boolean inOrder = false;
    while (inOrder != true) {
      boolean sorted = true;
      for (int i = 0; i < arrLen; i++) {
        if (i + 1 < arrLen) {
          if (nums[i + 1] < nums[i]) {
            sorted = false;
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
            System.out.println(Arrays.toString(nums));
            System.out.println();
          }
        }
      }
      if (sorted == true) {
        inOrder = true;
      }
    }

    return nums;
  }

  public static int[] insertionSort(int nums[]) {
    int arrLen = nums.length;
    for (int i = 0; i < arrLen; i++) {
      int count = i;
      while (count > 0) {
        if (nums[count] < nums[count - 1]) {
          int temp = nums[count];
          nums[count] = nums[count - 1];
          nums[count - 1] = temp;
          count = count - 1;
          System.out.println(Arrays.toString(nums));
          System.out.println();
        } else {
          count = 0;
        }
      }

    }

    return nums;
  }

  public static int[] selectionSort(int nums[]) {
    int arrLen = nums.length;
    for (int i = 0; i < arrLen - 1; i++) {
      int stored = i;
      for (int x = i + 1; x < arrLen; x++) {
        if (nums[stored] > nums[x]) {
          stored = x;
        }
      }
      int temp = nums[i];
      nums[i] = nums[stored];
      nums[stored] = temp;
      System.out.println(Arrays.toString(nums));
      System.out.println();

    }
    return nums;
  }

  public static void quickSort(int nums[]) {
    quickSorter(nums, 0, nums.length - 1);
  }

  public static void quickSorter(int[] nums, int lNum, int rNum) {
    if (lNum >= rNum) {
      return;
    }
    int pivot = nums[(lNum + rNum) / 2];
    int index = splitting(nums, lNum, rNum, pivot);
    quickSorter(nums, lNum, index - 1);
    quickSorter(nums, index, rNum);

  }

  public static int splitting(int[] nums, int lNum, int rNum, int pivot) {
    while (lNum <= rNum) {

      while (nums[lNum] < pivot) {
        lNum++;
      }

      while (nums[rNum] > pivot) {
        rNum--;
      }

      if (lNum <= rNum) {
        int temp = nums[lNum];
        nums[rNum] = nums[lNum];
        nums[lNum] = temp;
        lNum ++;
        rNum--;
      }

    }

    return lNum;
  }

  public static int[] mergeSorter(int nums[]) {
    int arrLen = nums.length; // finds length of array

    if (arrLen == 1 || arrLen == 0) {
      return nums;
    } else {
      int arrMid = arrLen / 2;
      int lArr[] = mergeSorter(Arrays.copyOfRange(nums, 0, arrMid));
      int rArr[] = mergeSorter(Arrays.copyOfRange(nums, arrMid, arrLen));

      return merger(lArr, rArr);
    }

  }

  public static int[] merger(int[] lArr, int[] rArr) {
    int comLen = (lArr.length + rArr.length);
    int indexL = 0;
    int indexR = 0;
    int[] sorted = new int[0];

    for (int i = 0; i < (comLen); i++) {
      if (indexL != lArr.length && indexR != rArr.length) {
        if (lArr[indexL] > rArr[indexR]) {
          sorted = Arrays.copyOf(sorted, sorted.length + 1);
          sorted[sorted.length - 1] = rArr[indexR];
          indexR++;
        } else {
          sorted = Arrays.copyOf(sorted, sorted.length + 1);
          sorted[sorted.length - 1] = lArr[indexL];
          indexL++;
        }
      } else if (indexL == lArr.length) {
        sorted = Arrays.copyOf(sorted, sorted.length + 1);
        sorted[sorted.length - 1] = rArr[indexR];
        indexR++;
      } else if (indexR == rArr.length) {
        sorted = Arrays.copyOf(sorted, sorted.length + 1);
        sorted[sorted.length - 1] = lArr[indexL];
        indexL++;
      }
      System.out.println(Arrays.toString(lArr));
      System.out.println(Arrays.toString(rArr));
      System.out.println(Arrays.toString(sorted));

    }

    return sorted;
  }

public static int[] gnomeSorter(int[] nums) {
		int arrLen = nums.length;
		int place = 0;
				
		while (place < arrLen) {
			if(place == 0) {
				place = place + 1;
			} else {
				if (nums[place] < nums[place -1]) {
					 int temp = nums[place]; //if proceeding value is lower then elements swap
			         nums[place] = nums[place - 1];
			         nums[place - 1] = temp;
               place = place - 1;
				} else {
					place = place + 1;
				}
			}
      System.out.println(Arrays.toString(nums));
		}
		return nums;
	}


  

}
