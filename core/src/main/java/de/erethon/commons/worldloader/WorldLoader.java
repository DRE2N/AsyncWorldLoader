/*
 * Copyright (C) 2015-2018 Daniel Saukel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.erethon.commons.worldloader;

import de.erethon.commons.compatibility.CompatibilityHandler;
import org.bukkit.World;
import org.bukkit.WorldCreator;

/**
 * A custom thread safe world loader.
 *
 * @author Daniel Saukel
 */
public class WorldLoader {

    static InternalsProvider internals;

    static {
        switch (CompatibilityHandler.getInstance().getInternals()) {
            case v1_13_R1:
                internals = new v1_13_R1();
                break;
            case v1_12_R1:
                internals = new v1_12_R1();
                break;
            case v1_11_R1:
                internals = new v1_11_R1();
                break;
            case v1_10_R1:
                internals = new v1_10_R1();
                break;
            case v1_9_R2:
                internals = new v1_9_R2();
                break;
            case v1_9_R1:
                internals = new v1_9_R1();
                break;
            case v1_8_R3:
                internals = new v1_8_R3();
                break;
            case v1_8_R2:
                internals = new v1_8_R2();
                break;
            case v1_8_R1:
                internals = new v1_8_R1();
                break;
            default:
                internals = new InternalsProvider();
        }
    }

    /**
     * @param creator
     * the WorldCreator which stores the information to create the new world
     * @return
     * the new World
     */
    public static World createWorld(WorldCreator creator) {
        return internals.createWorld(creator);
    }

}
