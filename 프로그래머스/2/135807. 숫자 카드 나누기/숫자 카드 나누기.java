class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = findGcd(arrayA);
        int gcdB = findGcd(arrayB);
        
        int A = validate(gcdA, arrayB) ? gcdA : 0;
        int B = validate(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(A, B);
    }
    
    //최대공약수 
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    
    public int findGcd(int[] array) {
        
        int gcd = array[0];
        
        for(int num : array) {
            
            gcd = gcd(gcd, num);
            
        }
        return gcd;
    }
    
    public boolean validate(int gcd, int[] array) {
        
        for(int num : array) {
            
            if(num % gcd == 0) return false;
        }
        return true;
    }
}