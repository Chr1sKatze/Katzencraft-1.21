GerstenCropBLock:
expected behaviour = 
✘ Gersten Seeds can be placed on farmland and maintain it without water. 
✓ Gersten Seeds can be placed on moisturized farmland.
✓ Gersten Seeds grow GerstenBottomCropBlock until MaxAge is reached.
✓ GerstenBottomCropBlock growing speed is affected by whether the farmland is dry or moisturized.
✓ GerstenBottomCropBlock only drops Seeds as loot once broken in any age state.
✘ GerstenBottomCropBlock places GerstenTopCropBlock automatically on top of itself once MaxAge is reached.
✓ breaking GerstenBottomCropBLock breaks GerstenTopCropBlock and vice versa.
✘ GerstenBottomCropBlock drops no loot once GerstenTopBlock is automatically placed.
✓ GerstenTopCropBlock drops Seeds in growing ages, but Seeds and Fruit at MaxAge.
✓ GerstenTopCropBlock growing speed is affected by whether the farmland GerstenBottomCropBlock grows on is dry or moisturized.
✓ Once GerstenTopCropBlock reaches MaxAge, GerstenBottomCropBlock and GerstenTopCropBlock are not allowed to tick.
