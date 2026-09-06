/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.richfaces.cdk.templatecompiler.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Nick Belaevski
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ClientBehavior {
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    private String event;
    @XmlAttribute(name = "default")
    private boolean defaultEvent;

    /**
     * <p class="changed_added_4_0">
     * </p>
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * <p class="changed_added_4_0">
     * </p>
     *
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * <p class="changed_added_4_0">
     * </p>
     *
     * @return the default
     */
    public boolean isDefaultEvent() {
        return defaultEvent;
    }

    /**
     * <p class="changed_added_4_0">
     * </p>
     *
     * @param defaultEvent the default to set
     */
    public void setDefaultEvent(boolean defaultEvent) {
        this.defaultEvent = defaultEvent;
    }
}
