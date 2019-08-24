class suzhu
{
	public static void main(String args[])
	{
		int[] arr = {10,11,15,2,30,17,1};
		paiXu(arr);
	}

	public static void paiXu(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if( arr[i] > arr[j] )
				{
					int pmt = arr[i];
					arr[i] = arr[j];
					arr[j] = pmt;
				}
			}
		}
		for(int k=0;k<arr.length;k++)
		{
			System.out.println("arr[]สýื้ฃบ"+arr[k]);
		}
	}	
}
