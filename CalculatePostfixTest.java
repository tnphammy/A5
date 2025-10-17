public class CalculatePostfixTest {
    public static void main(String[] args) {
        Queue<Object> eq = Tokenizer.readTokens("%");
        Double result = CalculatePostfix.postfixToResult(eq);
        System.out.println("Results: " + result);
    }
}
