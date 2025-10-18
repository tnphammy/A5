public class CalculatePostfixTest {
    public static void main(String[] args) {
        Queue<Object> eq = Tokenizer.readTokens("2 ^ 3 ^ 4");
        Double result = CalculateInfix.infixToPostfix(eq);
        System.out.println("Results: " + result);
    }
}
