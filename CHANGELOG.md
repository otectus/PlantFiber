# Changelog

## [1.0.1] - 2026-03-23

### Bug Fixes
- Added `forge:loot_table_id` condition to loot modifier JSON so it only fires for block drops instead of every loot event in the game
- Fixed grass armor being equippable via shift-click or dispenser when disabled in config by overriding `canEquip()`

### Corrections
- Renamed "Grass Block" to "Grass Fiber Block" in localization to avoid conflict with vanilla's Grass Block
- Added missing `minecraft:kelp_plant`, `minecraft:cave_vines`, and `minecraft:cave_vines_plant` to vegetation tag
- Made Grass Fiber Block flammable (ignitedByLava, flammability 60, fire spread 30)
- Replaced fragile blind field scanning in ClientSetup with targeted `ObfuscationReflectionHelper.findField()` using SRG name

### Enhancements
- Added `minecraft:mineable/hoe` tag for Grass Fiber Block
- Changed bandage/plaster use animation from EAT to BOW
- Expanded vegetation tag with 13 additional plant blocks (dead bush, lily pad, spore blossom, dripleaf, hanging roots, moss carpet, pitcher plant, torchflower, pink petals)
- Added tooltips to healing items showing regeneration level, duration, and cooldown
- Added decomposition recipe: 1 Grass Fiber Block -> 9 Plant Fiber

### Repo Setup
- Added proper `.gitignore` for Forge mod projects
- Removed platform-specific Java home path from `gradle.properties`
