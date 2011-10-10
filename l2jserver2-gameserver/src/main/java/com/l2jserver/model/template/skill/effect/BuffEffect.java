/*
 * This file is part of l2jserver <l2jserver.com>.
 *
 * l2jserver is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * l2jserver is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with l2jserver.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.model.template.skill.effect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.l2jserver.model.template.skill.SkillEffect;

/**
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeleportEffect")
public class BuffEffect extends SkillEffect {
	public enum SkillTeleportEffectLocation {
		TARGET, OFFSET_FROM_TARGET, POINT;
	}

	@XmlAttribute(name = "type", required = false)
	protected SkillTeleportEffectLocation type = SkillTeleportEffectLocation.TARGET;
	
	

	/**
	 * @return the teleport effect type
	 */
	public SkillTeleportEffectLocation getType() {
		return type;
	}
}
