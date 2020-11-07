package com.toteuch.auctiondb.json;

public class Item {
	private Long id;
	private int context;
	private ItemModifier[] modifiers;
	private int pet_breed_id;
	private int pet_level;
	private int pet_quality_id;
	private int pet_species_id;
	private int[] bonus_lists;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getContext() {
		return context;
	}

	public void setContext(int context) {
		this.context = context;
	}

	public ItemModifier[] getModifiers() {
		return modifiers;
	}

	public void setModifiers(ItemModifier[] modifiers) {
		this.modifiers = modifiers;
	}

	public int getPet_breed_id() {
		return pet_breed_id;
	}

	public void setPet_breed_id(int pet_breed_id) {
		this.pet_breed_id = pet_breed_id;
	}

	public int getPet_level() {
		return pet_level;
	}

	public void setPet_level(int pet_level) {
		this.pet_level = pet_level;
	}

	public int getPet_quality_id() {
		return pet_quality_id;
	}

	public void setPet_quality_id(int pet_quality_id) {
		this.pet_quality_id = pet_quality_id;
	}

	public int getPet_species_id() {
		return pet_species_id;
	}

	public void setPet_species_id(int pet_species_id) {
		this.pet_species_id = pet_species_id;
	}

	public int[] getBonus_lists() {
		return bonus_lists;
	}

	public void setBonus_lists(int[] bonus_lists) {
		this.bonus_lists = bonus_lists;
	}
}
