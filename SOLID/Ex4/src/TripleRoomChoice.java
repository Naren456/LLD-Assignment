public class TripleRoomChoice implements RoomChoice {
    @Override
    public boolean isSameType(int roomType) { return roomType == LegacyRoomTypes.TRIPLE; }
    @Override
    public Money getBase() { return new Money(15000.0); }
}