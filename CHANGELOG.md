# Changelog

## [1.0.2] - 2026-03-23

### Custom Grass Bed
- Replaced vanilla BedBlock with custom GrassBedBlock using JSON block models instead of BedRenderer
- Grass Bed now renders as a 3D grass mound with scattered horizontal grass overlay planes
- Head block features a raised pillow hump at the far end
- Grass strands lay flat across the surface with subtle tilt for natural depth
- Dedicated 3D hand-held item model with proper display transforms for all views
- Eliminated all reflection hacks (ModSetup validBlocks, ClientSetup BED_MATERIALS)
- Added custom BlockEntity and BlockEntityType for bed sleep/respawn compatibility
- Registered cutout render type for proper grass texture transparency

### Bug Fixes
- Fixed crash caused by invalid ResourceLocation `.*:blocks/.*` in loot modifier condition — reverted to empty conditions with Java-side filtering

## [1.0.1] - 2026-03-23

### Bug Fixes
- Fixed grass armor being equippable via shift-click or dispenser when disabled in config by overriding `canEquip()`

### Corrections
- Renamed "Grass Block" to "Grass Fiber Block" in localization to avoid conflict with vanilla's Grass Block
- Added missing `minecraft:kelp_plant`, `minecraft:cave_vines`, and `minecraft:cave_vines_plant` to vegetation tag
- Made Grass Fiber Block flammable (ignitedByLava, flammability 60, fire spread 30)

### Enhancements
- Added `minecraft:mineable/hoe` tag for Grass Fiber Block
- Changed bandage/plaster use animation from EAT to BOW
- Expanded vegetation tag with 13 additional plant blocks (dead bush, lily pad, spore blossom, dripleaf, hanging roots, moss carpet, pitcher plant, torchflower, pink petals)
- Added tooltips to healing items showing regeneration level, duration, and cooldown
- Added decomposition recipe: 1 Grass Fiber Block -> 9 Plant Fiber

### Repo Setup
- Added proper `.gitignore` for Forge mod projects
- Removed platform-specific Java home path from `gradle.properties`
