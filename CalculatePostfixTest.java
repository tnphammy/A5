public class CalculatePostfixTest {
    public static void main(String[] args) {
        Queue<Object> eq = Tokenizer.readTokens("3 2 5 * +");
        Double result = CalculatePostfix.postfixToResult(eq);
        System.out.println("Results: " + result);
    }
}
