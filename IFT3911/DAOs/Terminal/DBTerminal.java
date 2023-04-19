package DAOs.Terminal;

import Models.PlaneTripModel.Airport;
import Models.TripModel.Terminal;

public class DBTerminal {
    private TerminalType type;
    private Terminal terminal;

    public DBTerminal(TerminalType type, Terminal terminal) {
        this.type = type;
        this.terminal = terminal;
    }

    public TerminalType getType() {
        return type;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Airport updated_airport) {
        this.terminal = updated_airport;
    }
}
