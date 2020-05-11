package sprint12;

public class Sprint12Task2 {
    /*
    Suppose, you have class from task1 ParallelCalculator that is able to execute an operation in separate thread.
    It uses an implementation of Runnable for this.
    Constructor of ParallelCalculator takes 3 parameters:
    BinaryOperator<Integer> to define an operation that will be executed, int operand1 and int operand2.
    ParallelCalculator class has not private int result field where the result of the operation is written when
    operation is executed.

    You need to create Accountant class with a static method sum that takes 2 int parameters and returns their sum.
    The sum must be evaluated in a separate thread (please, do not call run() method of ParallelCalculator.
    Use start() on Thread object). Use ParallelCalculator for this. Method sum doesn't throw any checked exceptions.

    Using Thread.sleep() is unwelcomed in this task.
     */

    static class Accountant {

        public static int sum(int x, int y){
            Sprint12Task1.ParallelCalculator calculator = new Sprint12Task1.ParallelCalculator(Integer::sum, x, y);
            Thread calcThread = new Thread(calculator);
            calcThread.start();
            try {
                calcThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted");
            }
            return calculator.result;
        }
    }
}
