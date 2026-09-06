package org.richfaces;

import jakarta.el.MethodExpression;
import jakarta.faces.view.facelets.FaceletContext;
import jakarta.faces.view.facelets.Metadata;
import jakarta.faces.view.facelets.TagAttribute;

public class MethodMetadata extends Metadata {

    public MethodMetadata(TagAttribute attribute, Class<String> class1, Class<Integer> class2) {
        // TODO Auto-generated constructor stub
    }

    public MethodMetadata(TagAttribute attribute, Class<String> class1) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void applyMetadata(FaceletContext ctx, Object instance) {
    }

    protected MethodExpression getMethodExpression(FaceletContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

}
