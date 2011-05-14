package script.template.character;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.CharacterTemplateID;
import com.l2jserver.model.id.template.factory.CharacterTemplateIDFactory;
import com.l2jserver.model.world.L2Character;
import com.l2jserver.model.world.character.CharacterClass;
import com.l2jserver.util.dimensional.Point;

public class InspectorTemplate extends WarderTemplate {
	@Inject
	public InspectorTemplate(CharacterTemplateIDFactory factory) {
		super(factory.createID(CharacterClass.INSPECTOR.id),
				CharacterClass.INSPECTOR,
				// ATTRIBUTES
				28,// INT
				39,// STR
				30,// CON
				27,// MEN
				35,// DEX
				11,// WIT
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
				87000,// max inventory weight
				false,// can craft
				Point.fromXYZ(-125533, 38114, 1142)// spawn location
		);
	}

	protected InspectorTemplate(CharacterTemplateID id,
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
