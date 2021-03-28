package domain;

public class Car {
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final int NAME_LENGTH_BOUND = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position += 1;
        }
    }

    private void validateName(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(name + ": 자동차 이름은 5글자 이하여야 합니다.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("공백으로만 이루어진 이름을 생성할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + COLON + DASH.repeat(position) + '\n';
    }
}
