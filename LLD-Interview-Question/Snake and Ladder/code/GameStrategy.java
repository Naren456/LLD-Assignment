
public interface GameStrategy {
    public boolean shouldRollAgain(int diceValue);
    public boolean isTurnVoid(int consecutiveSixes);
    public void resetTurn(Player u);
}