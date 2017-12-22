package ridnaxata.sandbox.sb_013_UserInput;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class UserInput {

    public static class TextInput {

        private final StringBuilder value;

        public TextInput() {
            this.value = new StringBuilder();
        }

        public String getValue() {
            return value.toString();
        }

        public void add(Character c) {
            Stream.of(c)
                    .filter(predicate())
                    .forEach(value::append);

        }

        protected Predicate<Character> predicate() {
            return (c) -> true;
        }
    }

    public static class NumericInput extends TextInput{

        protected Predicate<Character> predicate() {
            return Character::isDigit;
        }

    }

    public static void main(String[] args) {
        TextInput input = new TextInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());

        TextInput input1 = new NumericInput();
        input1.add('1');
        input1.add('a');
        input1.add('0');
        System.out.println(input1.getValue());
    }

}
