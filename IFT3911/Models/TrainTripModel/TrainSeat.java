package Models.TrainTripModel;

import Models.TripModel.Reservable;

public class TrainSeat extends Reservable<TrainReservationOption> {

        private static String[] alphabet = { "A", "B", "C" };
    
        private int row;
        private String column;
    
        public TrainSeat(int row, int column) {
            super();
            this.row = row;
            this.column = TrainSeat.alphabet[column].toString();
        }
    
        public int getRow() {
            return this.row;
        }
    
        public String getColumn() {
            return this.column;
        }
        
        @Override
        public String toString() {
            return "TrainSeat [row=" + row + ", column=" + column + "]";
        }
}