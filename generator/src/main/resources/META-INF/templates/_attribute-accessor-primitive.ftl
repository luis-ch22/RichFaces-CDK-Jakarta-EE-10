    public void ${attribute.setterName}(${attribute.typeName} ${attribute.name}) {
        this.${attribute.name} = ${attribute.name};
        this.is${attribute.capitalizeName}Setted = true;
    }

    public ${attribute.typeName} ${attribute.getterName}() {
        if (this.is${attribute.capitalizeName}Setted) {
            return ${attribute.name};
        }

        jakarta.el.ValueExpression vb = getValueBinding("${attribute.name}");
        if (vb != null) {
            ${attribute.typeForCasting} value = (${attribute.typeForCasting}) vb.getValue(getFacesContext().getELContext());
            if (value == null) {
                return ${attribute.name};
            }
            return value;
        } else {
            return this.${attribute.name};
        }
    }