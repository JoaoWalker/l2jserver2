package com.l2jserver.game.net.packet.client;

import org.jboss.netty.buffer.ChannelBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.l2jserver.game.net.Lineage2Connection;
import com.l2jserver.game.net.packet.AbstractClientPacket;
import com.l2jserver.game.net.packet.server.CharacterTemplatePacket;
import com.l2jserver.model.id.template.CharacterTemplateID;
import com.l2jserver.model.id.template.factory.CharacterTemplateIDFactory;
import com.l2jserver.model.template.CharacterTemplate;
import com.l2jserver.model.world.character.CharacterClass;

/**
 * Requests the creation of a new Character. The list of character templates is
 * sent to the client, meaning that the client is authorized to create
 * characters.
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class RequestCharacterTemplatesPacket extends AbstractClientPacket {
	public static final int OPCODE = 0x13;

	public static final CharacterClass[] TEMPLATE_CLASSES = {
			CharacterClass.HUMAN_FIGHTER, CharacterClass.HUMAN_MYSTIC,
			CharacterClass.ELVEN_FIGHTER, CharacterClass.ELVEN_MYSTIC,
			CharacterClass.DARK_FIGHTER, CharacterClass.DARK_MYSTIC,
			CharacterClass.ORC_FIGHTER, CharacterClass.ORC_MYSTIC,
			CharacterClass.DWARVEN_FIGHTER, CharacterClass.MALE_SOLDIER,
			CharacterClass.FEMALE_SOLDIER };

	/**
	 * The logger
	 */
	private static final Logger log = LoggerFactory
			.getLogger(RequestCharacterTemplatesPacket.class);

	private final CharacterTemplateIDFactory idFactory;

	@Inject
	public RequestCharacterTemplatesPacket(CharacterTemplateIDFactory idFactory) {
		this.idFactory = idFactory;
	}

	@Override
	public void read(Lineage2Connection conn, ChannelBuffer buffer) {
	}

	@Override
	public void process(final Lineage2Connection conn) {
		log.debug("Requested character templates");
		for (final CharacterClass charClass : TEMPLATE_CLASSES) {
			final CharacterTemplateID id = idFactory.createID(charClass.id);
			final CharacterTemplate template = id.getTemplate();
			final CharacterTemplatePacket templatePacket = new CharacterTemplatePacket(
					template);

			conn.write(templatePacket);
		}
	}
}
