/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package cl.uchile.dcc.cc4401.protosim.components;

import java.awt.Color;
import java.util.List;

import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.AttributeOption;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.tools.FactoryDescription;
import com.cburch.logisim.tools.Library;
import com.cburch.logisim.tools.Tool;
import static com.cburch.logisim.util.LocaleString.*;

public class Io extends Library {
    static final AttributeOption LABEL_CENTER = new AttributeOption("center", "center", getFromLocale("ioLabelCenter"));

    static final Attribute<Color> ATTR_COLOR = Attributes.forColor("color",
            getFromLocale("ioColorAttr"));
    static final Attribute<Color> ATTR_ON_COLOR
        = Attributes.forColor("color", getFromLocale("ioOnColor"));
    static final Attribute<Color> ATTR_OFF_COLOR
        = Attributes.forColor("offcolor", getFromLocale("ioOffColor"));
    static final Attribute<Color> ATTR_BACKGROUND
        = Attributes.forColor("bg", getFromLocale("ioBackgroundColor"));
    static final Attribute<Object> ATTR_LABEL_LOC = Attributes.forOption("labelloc",
            getFromLocale("ioLabelLocAttr"),
            new Object[] { LABEL_CENTER, Direction.NORTH, Direction.SOUTH,
                Direction.EAST, Direction.WEST });
    static final Attribute<Color> ATTR_LABEL_COLOR = Attributes.forColor("labelcolor",
            getFromLocale("ioLabelColorAttr"));
    static final Attribute<Boolean> ATTR_ACTIVE = Attributes.forBoolean("active",
            getFromLocale("ioActiveAttr"));

    static final Color DEFAULT_BACKGROUND = new Color(255, 255, 255, 0);

    private static FactoryDescription[] DESCRIPTIONS = {
        new FactoryDescription("Button", getFromLocale("buttonComponent"),
                "button.svg", "Button"),
    };

    private List<Tool> tools = null;

    public Io() { }

    @Override
    public String getName() { return "I/O"; }

    @Override
    public String getDisplayName() { return getFromLocale("ioLibrary"); }

    @Override
    public List<Tool> getTools() {
        if (tools == null) {
            tools = FactoryDescription.getTools(Io.class, DESCRIPTIONS);
        }
        return tools;
    }
}
