package script.template.character;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.CharacterTemplateID;
import com.l2jserver.model.id.template.factory.CharacterTemplateIDFactory;
import com.l2jserver.model.world.L2Character;
import com.l2jserver.model.world.character.CharacterClass;
import com.l2jserver.util.dimensional.Point;

public class GhosthunterTemplate extends AbyssWalkerTemplate {
	@Inject
	public GhosthunterTemplate(CharacterTemplateIDFactory factory) {
		super(factory.createID(CharacterClass.ghostHunter.id),
				CharacterClass.ghostHunter,
				// ATTRIBUTES
				25,// INT
				41,// STR
				32,// CON
				26,// MEN
				34,// DEX
				12,// WIT
				4,// physical attack
				6,// magical attack
				80,// physical def
				41,// magical def
				300,// attack speed
				333,// cast speed
				35,// accuracy
				45,// critical
				35,// evasion
				122,// move speed
				69000,// max inventory weight
				false,// can craft
				Point.fromXYZ(28377, 10916, -4224)// spawn location
		);
	}

	protected GhosthunterTemplate(CharacterTemplateID id,
			CharacterClass characterClass, int intelligence, int strength,
			int concentration, int mentality, int dexterity, int witness,
			int physicalAttack, int magicalAttack, int physicalDefense,
			int magicalDefense, int attackSpeed, int castSpeed, int accuracy,
			int criticalChance, int evasionChance, int moveSpeed,
			int maxWeigth, boolean craft, Point spawnLocation) {
		super(id, characterClass, intelligence, strength, concentration,
				mentality, dexterity, witness, physicalAttack, magicalAttack,
				physicalDefense, magicalDefense, attackSpeed, castSpeed,
				accuracy, criticalChance, evasionChance, moveSpeed, maxWeigth,
				craft, spawnLocation);
	}

	@Override
	public L2Character create() {
		final L2Character character = super.create();
		// TODO register skills
		return character;
	}
}
