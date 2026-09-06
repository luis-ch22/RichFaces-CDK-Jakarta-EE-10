    public void ${attribute.setterName}(${attribute.typeName} ${attribute.name}) {
        this.${attribute.name} = ${attribute.name};
    }

    public ${attribute.typeName} ${attribute.getterName}() {
    <#if ! attribute.literal > 
        if (${attribute.name} != null) {
            return ${attribute.name};
        }

        jakarta.el.ValueExpression vb = getValueBinding("${attribute.name}");
        if (null != vb) {
            return (${attribute.typeName}) vb.getValue(getFacesContext().getELContext());
        }
    </#if>
        return ${attribute.name};
    }