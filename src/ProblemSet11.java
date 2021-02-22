import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet11 {
    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start < end) {

            int count = start;
            ArrayList<String> temp = new ArrayList<>();

            //check contents for multiples of 3 and 5
            while (count < end) {
                if (count % 3 == 0) {
                    if (count % 5 == 0) {
                        temp.add("FizzBuzz");
                    } else {
                        temp.add("Fizz");
                    }
                } else if (count % 5 == 0) {
                    temp.add("Buzz");
                } else {
                    temp.add(String.valueOf(count));
                }
                count++;
            }
            return temp;
        }
        return null;
    }


    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers != null) {
            switch (numbers.size()) {
                case 0:
                case 1:
                    return numbers.size();
                default:
                    break;
            }

            int span = 1;
            for (int i = 0; i < numbers.size(); i++) {
                int num = numbers.get(i);

                for (int z = numbers.size() - 1; z > i; z--) {
                    if (numbers.get(z) == num && span < (z - i + 1)) {
                        span = z - i + 1;
                    }

                }
            }
            return span;
        }
        return -1;
    }



    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers != null) {
            ArrayList<Integer> four = new ArrayList<>();
            ArrayList<Integer> three = new ArrayList<>();

            //search and add 3 or 4 respectively to their arrays
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 3) {
                    three.add(i);
                } else if (numbers.get(i) == 4) {
                    four.add(i);
                }
            }


            if (four.size() == three.size() && three.get(0) < four.get(0)) {
                boolean count = true;

                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 3 && numbers.get(i + 1) == 3) {
                        count = false;
                        break;
                    }
                }

                if (count) {
                    for (int i = 0; i < four.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < three.size(); i++) {
                        numbers.remove(Integer.valueOf(3));
                    }
                    for (Integer integer : three) {
                        numbers.add(integer, 3);
                        numbers.add(integer + 1, 4);
                    }

                    return numbers;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers != null) {
            ArrayList<Integer> four = new ArrayList<>();
            ArrayList<Integer> five = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 5) {
                    five.add(i);
                } else if (numbers.get(i) == 4) {
                    four.add(i);
                }
            }
            
            //check
            if (four.size() == five.size()) {
                boolean count = true;

                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 4 && numbers.get(i + 1) == 4) {
                        count = false;
                    }
                }

                if (count) {
                    for (int i = 0; i < four.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < five.size(); i++) {
                        numbers.remove(Integer.valueOf(5));
                    }
                    for (int i = 0; i < five.size(); i++) {
                        numbers.add(four.get(i), 4);
                        numbers.add(four.get(i) + 1, 5);
                    }
                    return numbers;
                }
            }
        }
        return null;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers != null && numbers.size() > 0) {
            for (int i = 0; i < numbers.size(); i++) {

                ArrayList<Integer> start = new ArrayList<Integer>(numbers.subList(0, i+1));
                ArrayList<Integer> end = new ArrayList<Integer>(numbers.subList(i+1, numbers.size()));


                int startsum = 0;
                int endsum = 0;

                for (int n : start) {
                    startsum += n;
                }
                for (int n : end) {
                    endsum += n;
                }

                if (startsum == endsum) return true;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {

        if (outer != null && inner != null && outer.size() > 0 && inner.size() > 0) {
            for (int i = 0; i < inner.size() - 1; i++) {
                if (inner.get(i) > inner.get(i + 1))
                    return false;
            }
            for (int i = 0; i < outer.size() - 1; i++) {
                if (outer.get(i) > outer.get(i + 1)) {
                    return false;
                }
            }
            int count = 0;

            for (Integer integer : inner) {
                for (int z : outer) {
                    if (z == integer) {
                        count++;
                        break;
                    }
                }
            }
            if (count < inner.size()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                ArrayList<Integer> out = new ArrayList<Integer>(0);
                return out;
            }
            ArrayList<Integer> out = new ArrayList<Integer>();
            for (int i = n; i > 0; i--) {
                int sub = i - 1;

                for (int z = 0; z < n; z++) {
                    if (sub > 0) {
                        out.add(0);
                    } else {
                        out.add(n - z);
                    }
                    sub--;
                }
            }
            return out;
        }
        return null;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                ArrayList<Integer> out = new ArrayList<Integer>(0);
                return out;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            int length = 1;
            for (int i = 0; i < n; i++) {
                int count = 1;

                for (int z = 0; z < length; z++) {
                    arr.add(count);
                    count++;
                }
                length++;
            }

            return arr;
        }
        return null;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int l1 = numbers.size();
            int l2 = l1;

            int[][] mir = new int[l1 + 1][l2 + 1];
            int count = 0;

            for (int i = 0; i <= l1; i++) {
                for (int z = 0; z <= l2; z++) {
                    if (i == 0 || z == 0) {
                        mir[i][z] = 0;
                    } else if (numbers.get(i - 1) == numbers.get(l2 - z)) {
                        mir[i][z] = mir[i-1][z-1] + 1;
                        count = Math.max(count, mir[i][z]);
                    } else {
                        mir[i][z] = 0;
                    }
                }
            }
            return count;
        }
        return -1;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int current = numbers.get(0);
            int past = current;
            int past1 = past;
            int count = 0;

            if (numbers.get(0).equals(numbers.get(1))) count++;
            for (Integer number : numbers) {
                past1 = past;
                past = current;
                current = number;

                if (current == past && past != past1) {
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}