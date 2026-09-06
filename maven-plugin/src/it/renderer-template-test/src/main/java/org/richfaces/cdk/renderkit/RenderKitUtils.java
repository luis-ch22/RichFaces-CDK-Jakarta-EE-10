package org.richfaces.cdk.renderkit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;

/**
 * Minimal stand-in for the runtime's {@code org.richfaces.renderkit.RenderKitUtils},
 * providing just the pass-through-attributes support exercised by the
 * {@code link.template.xml} test template. The real implementation lives in the
 * richfaces runtime repository, which this CDK integration test does not depend on.
 */
public final class RenderKitUtils {

    private RenderKitUtils() {
    }

    public static Attributes attributes() {
        return new Attributes();
    }

    public static void renderPassThroughAttributes(FacesContext facesContext, UIComponent component,
            Attributes attributes) throws IOException {
        for (ComponentAttribute attribute : attributes.entries) {
            Object value = component.getAttributes().get(attribute.componentAttribute);
            if (!isEmpty(value)) {
                facesContext.getResponseWriter().writeAttribute(attribute.name, value, null);
            }
        }
    }

    private static boolean isEmpty(Object value) {
        return value == null || value.toString().length() == 0;
    }

    public enum ScriptHashVariableWrapper {
        noop, asArray, eventHandler;

        Object wrap(Object value) {
            return value;
        }
    }

    public static final class Attributes {
        private final List<ComponentAttribute> entries = new ArrayList<ComponentAttribute>();

        public Attributes generic(String name, String componentAttribute, String... events) {
            entries.add(new ComponentAttribute(name, componentAttribute));
            return this;
        }
    }

    private static final class ComponentAttribute {
        private final String name;
        private final String componentAttribute;

        private ComponentAttribute(String name, String componentAttribute) {
            this.name = name;
            this.componentAttribute = componentAttribute;
        }
    }
}
