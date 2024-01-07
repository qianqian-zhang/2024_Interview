package JPMorgan_Internship_OA;

//two pointer

//1. two player take turns, because it does not involve players choosing optimally, does not need DP.
//2. reverse an array: we are only picking elements depending on the order (reverse or not), so use two pointers instead of actually reversing the array
//   reversed: move right pointer, shrink from right
//   not reversed: move left pointer, shrink from left

public class MatchGame {
    //[1,3,2,5,4]
    //player1, player2
    //round 1: player1(1) [3,2,5,4]
    //round2: player2(3) [2,5,4]
    //round3: player1(3) [4,5]
    //round4: player2(7) [5]
    //round5: player1(8)[]

    //diff = 8 - 7 = 1
    public static int solution(int n, int[] seq) {
        //o(n) o(1)
        int player1 = 0;
        int player2 = 0;

        int left = 0;
        int right = seq.length - 1;

        boolean leftToRight = true;
        int turn = 0;

        while(left <= right) {
            int num;

            //check if the current range of array should be reversed or not
            //if in reversed order, move right pointer, if not, move left pointer
            if(leftToRight) {
                num = seq[left];
                left++;
            }else{
                num = seq[right];
                right--;
            }

            //depends on whose tern it is, add score to current player
            if(turn % 2 == 1) {
                player2 += num;
            }else{
                player1 += num;
            }

            //System.out.println("player1: " + player1 + " player2: " + player2);

            //if current num is even, current range should be reversed, change flag
            if(num % 2 == 0) {
                leftToRight = !leftToRight;
            }

            turn++;
        }

        return player1 - player2;
    }
}
