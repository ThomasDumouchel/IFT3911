package DAOs.Terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAOs.Trip.TripType;
import DAOs.TripObserver.TripEventManager;
import Models.TripModel.Terminal;

public class TerminalDAO {

    private List<DBTerminal> terminals;
    private TripEventManager tripEventManager;

    public TerminalDAO(TripEventManager tripEventManager) {
        this.tripEventManager = tripEventManager;
        this.terminals = new ArrayList<>();
    }

    private List<DBTerminal> getDBTerminals(TripType type){
        var res = new ArrayList<DBTerminal>();
        for (var terminal : terminals) {
            if (terminal.getType() == type) {
                res.add(terminal);
            }
        }
        return res;
    }

    public Terminal update(TripType type, String name, Terminal updated_terminal) {
        for (var dbTerminal : getDBTerminals(type)) {
            if (dbTerminal.getTerminal().getName().equals(name)) {
                var old_terminal = TerminalDAO.ToAppModel(dbTerminal);
                dbTerminal.setTerminal(updated_terminal);
                return old_terminal;
            }
        }
        throw new RuntimeException("Terminal not found");
    }

    public static Terminal ToAppModel(DBTerminal dbWrapper) {
        return dbWrapper.getTerminal();
    }


    public void addTerminal(TripType tripType, Terminal terminal) {
        terminals.add(new DBTerminal(tripType, terminal));
    }

    public Terminal deleteTerminal(TripType tripType, String id) {
        for (var dbTerminal : getDBTerminals(tripType)) {
            if (dbTerminal.getTerminal().getId().equals(id)) {
                terminals.remove(dbTerminal);
                return dbTerminal.getTerminal();
            }
        }
        throw new RuntimeException("Terminal not found");
    }

    public Terminal updateTerminal(TripType tripType, String id, Terminal updated_terminal) {
        // TODO: seems incorrect
        for (var dbTerminal : getDBTerminals(tripType)) {
            if (dbTerminal.getTerminal().getId().equals(id)) {
                var old_terminal = TerminalDAO.ToAppModel(dbTerminal);
                dbTerminal.setTerminal(updated_terminal);
                return old_terminal;
            }
        }
        throw new RuntimeException("Terminal not found");
    }

    public List<Terminal> getTerminals(TripType tripType) {
        var res = new ArrayList<Terminal>();
        for (var terminal : getDBTerminals(tripType)) {
            res.add((Terminal)ToAppModel(terminal));
        }
        return res;
    }
     
}