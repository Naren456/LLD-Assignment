public class SingleRoomChoice implements RoomChoice {
    @Override
    public boolean isSameType(int roomType) { return roomType == LegacyRoomTypes.SINGLE; }
    @Override
    public Money getBase() { return new Money(15000.0); }
}