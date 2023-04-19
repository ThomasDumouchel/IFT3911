package DAOs.Terminal;

import java.util.ArrayList;
import java.util.List;

import Models.CruiseTripModel.Port;
import Models.PlaneTripModel.Airport;
import Models.TrainTripModel.TrainStation;
import Models.TripModel.Terminal;

public class TerminalDAO {

    List<DBTerminal> terminals;

    public TerminalDAO() {
        //TODO: Mock some data...
    }

    private List<DBTerminal> getDBTerminals(TerminalType type){
        var res = new ArrayList<DBTerminal>();
        for (var terminal : terminals) {
            if (terminal.getType() == type) {
                res.add(terminal);
            }
        }
        return res;
    }

    public void add(TerminalType type, Terminal terminal) {
        // TODO: verify for uniqueness
        terminals.add(ToDBModel(terminal));
    }

    public static Terminal ToAppModel(DBTerminal dbWrapper) {
        return dbWrapper.getTerminal();
    }

    public static DBTerminal ToDBModel(Terminal company) {
        TerminalType type = null;
        if (company instanceof Airport) {
            type = TerminalType.AIRPORT;
        } else if (company instanceof TrainStation) {
            type = TerminalType.TRAINSTATION;
        } else if (company instanceof Port) {
            type = TerminalType.PORT;
        }
        return new DBTerminal(type, company);
    }

    public Terminal update(TerminalType airport, String name, Airport updated_airport) {
        for (var terminal : getDBTerminals(airport)) {
            if (terminal.getType() == airport && terminal.getTerminal().getName().equals(name)) {
                var old_terminal = terminal.getTerminal();
                terminal.setTerminal(updated_airport);
                return old_terminal;
            }
        }
        throw new RuntimeException("Terminal not found");
    }
     
}