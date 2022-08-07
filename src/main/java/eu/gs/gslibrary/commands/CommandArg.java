package eu.gs.gslibrary.commands;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandArg {

    private final CommandAPI api;
    private final String arg;

    public CommandArg(CommandAPI api, String arg) {
        this.arg = arg;
        this.api = api;
    }

    public boolean isInt() {
        try {
            int i = Integer.parseInt(arg);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean isDouble() {
        try {
            double i = Double.parseDouble(arg);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean isFloat() {
        try {
            float i = Float.parseFloat(arg);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean isLong() {
        try {
            long i = Long.parseLong(arg);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean isPlayer() {
        return Bukkit.getPlayer(arg) != null;
    }

    public boolean isEntity() {
        return EntityType.fromName(arg.toUpperCase()) != null;
    }

    public boolean isMaterial() {
        try {
            XMaterial.matchXMaterial(arg.toUpperCase()).get();
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

    public String getAsString() {
        return arg;
    }

    public int getAsInt() {
        return Integer.parseInt(arg);
    }

    public double getAsDouble() {
        return Double.parseDouble(arg);
    }

    public float getAsFloat() {
        return Float.parseFloat(arg);
    }

    public long getAsLong() {
        return Long.parseLong(arg);
    }

    public Player getAsPlayer() {
        return Bukkit.getPlayer(arg);
    }

    public EntityType getAsEntity() {
        return EntityType.fromName(arg.toUpperCase());
    }

    public XMaterial getAsMaterial() {
        return XMaterial.matchXMaterial(arg.toUpperCase()).get();
    }

}
