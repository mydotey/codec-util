package org.mydotey.codec;

/**
 * @author koqizhao
 *
 * Nov 8, 2018
 */
public class PojoHello {

    private String hello;
    private String world;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hello == null) ? 0 : hello.hashCode());
        result = prime * result + ((world == null) ? 0 : world.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PojoHello other = (PojoHello) obj;
        if (hello == null) {
            if (other.hello != null)
                return false;
        } else if (!hello.equals(other.hello))
            return false;
        if (world == null) {
            if (other.world != null)
                return false;
        } else if (!world.equals(other.world))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PojoHello [hello=" + hello + ", world=" + world + "]";
    }

}
