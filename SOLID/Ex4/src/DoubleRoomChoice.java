public class DoubleRoomChoice implements RoomChoice {
    @Override
    public boolean isSameType(int roomType) { return roomType == LegacyRoomTypes.DOUBLE; }
    @Override
    public Money getBase() { return new Money(15000.0); }
}