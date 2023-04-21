package DAOs.Terminal;

import DAOs.Trip.TripType;
import Models.TripModel.Terminal;

public class DBTerminal {
    private TripType type;
    private Terminal terminal;

    public DBTerminal(TripType type, Terminal terminal) {
        this.type = type;
        this.terminal = terminal;
    }    

    public TripType getType() {
        return type;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal updated_terminal) {
        this.terminal = updated_terminal;
    }
}
