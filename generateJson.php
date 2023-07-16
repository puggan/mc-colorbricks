<?php

(static function () {
    $dataPath = __DIR__ . '/src/main/resources/data';
    $assetsPath = __DIR__ . '/src/main/resources/assets';
    $jsonOptions = JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE;
    $modId = 'colorbricks';
    $types = [
        'brick_blocks' => 'bricks',
        'brick_slabs' => 'brick_slab',
        'brick_stairs' => 'brick_stairs',
        'brick_walls' => 'brick_wall',
        'brick_columns' => 'brick_column',
    ];
    $baseForms = ['slabs', 'stairs', 'walls'];
    $colors = [
        'black',
        'blue',
        'brown',
        'cyan',
        'gray',
        'green',
        'light_blue',
        'light_gray',
        'lime',
        'magenta',
        'orange',
        'pink',
        'purple',
        'red',
        'white',
        'yellow',
    ];

    $columnLoadedCondition = [
        'condition' => 'fabric:allModsLoaded',
        'values' => [
            $modId,
            'columns',
        ],
    ];

    //<editor-fold desc="Directories">
    $dirs = [
        "{$assetsPath}",
        "{$assetsPath}/{$modId}",
        "{$assetsPath}/{$modId}/blockstates",
        "{$assetsPath}/{$modId}/models",
        "{$assetsPath}/{$modId}/models/block",
        "{$assetsPath}/{$modId}/models/item",
        "{$dataPath}",
        "{$dataPath}/columns",
        "{$dataPath}/columns/tags",
        "{$dataPath}/columns/tags/blocks",
        "{$dataPath}/minecraft",
        "{$dataPath}/minecraft/tags",
        "{$dataPath}/minecraft/tags/blocks",
        "{$dataPath}/minecraft/tags/blocks/mineable",
        "{$dataPath}/minecraft/tags/items",
        "{$dataPath}/{$modId}",
        "{$dataPath}/{$modId}/loot_tables",
        "{$dataPath}/{$modId}/loot_tables/blocks",
        "{$dataPath}/{$modId}/recipes",
        "{$dataPath}/{$modId}/tags",
        "{$dataPath}/{$modId}/tags/blocks",
        "{$dataPath}/{$modId}/tags/items",
    ];
    foreach ($dirs as $dir) {
        if (!is_dir($dir)) {
            mkdir($dir);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Minecraft Namespace">
    foreach ($baseForms as $blockType) {
        $jsonData = [
            'replace' => false,
            'values' => [
                "#{$modId}:brick_{$blockType}",
            ],
        ];
        file_put_contents("{$dataPath}/minecraft/tags/blocks/{$blockType}.json", json_encode($jsonData, $jsonOptions));
        file_put_contents("{$dataPath}/minecraft/tags/items/{$blockType}.json", json_encode($jsonData, $jsonOptions));
    }

    file_put_contents(
        "{$dataPath}/minecraft/tags/blocks/mineable/pickaxe.json",
        json_encode(
            [
                'replace' => false,
                'values' => [
                    "#{$modId}:color_bricks",
                ],
            ],
            $jsonOptions,
        ),
    );
    file_put_contents(
        "{$dataPath}/columns/tags/blocks/columns.json",
        json_encode(
            [
                'replace' => false,
                'values' => [
                    "#{$modId}:brick_columns",
                ],
            ],
            $jsonOptions,
        ),
    );
    //</editor-fold>

    //<editor-fold desc="Tags">
    $tags = [];
    foreach ($types as $typeTag => $type) {
        $blocks = [];
        $tags[$type] = "#{$modId}:{$typeTag}";
        switch ($type) {
            case 'brick_slab':
            case 'brick_stairs':
            case 'brick_wall':
                $blocks[] = "minecraft:{$type}";
                break;
            case 'brick_column':
                $blocks[] = [
                    'id' => 'columns:brick_column',
                    'required' => false,
                ];
                $tags[$type] = [
                    'id' => "#{$modId}:{$typeTag}",
                    'required' => false,
                ];
                break;
        }
        foreach ($colors as $color) {
            $blocks[] = "{$modId}:{$color}_{$type}";
        }
        $jsonData = [
                'replace' => false,
                'values' => $blocks,
            ];
        if ($type === 'brick_column') {
            $jsonData['fabric:conditions'][] = $columnLoadedCondition;
        }
        file_put_contents("{$dataPath}/{$modId}/tags/blocks/{$typeTag}.json", json_encode($jsonData, $jsonOptions));
        file_put_contents("{$dataPath}/{$modId}/tags/items/{$typeTag}.json", json_encode($jsonData, $jsonOptions));
    }
    sort($tags);
    $jsonData = [
            'replace' => false,
            'values' => array_values($tags),
        ];
    file_put_contents("{$dataPath}/{$modId}/tags/blocks/color_bricks.json", json_encode($jsonData, $jsonOptions));
    file_put_contents("{$dataPath}/{$modId}/tags/items/color_bricks.json", json_encode($jsonData, $jsonOptions));
    //</editor-fold>

    //<editor-fold desc="Receipts">
    foreach ($colors as $color) {
        foreach ($types as $typeTag => $type) {
            $dyeIngredients = ['item' => "minecraft:{$color}_dye",];
            $brickIngredients = ['tag' => "{$modId}:{$typeTag}",];
            $jsonData = [
                    'type' => 'minecraft:crafting_shapeless',
                    'group' => "color_{$type}",
                    'ingredients' => [
                        $dyeIngredients,
                        $brickIngredients,
                    ],
                    'result' => [
                        'item' => "{$modId}:{$color}_{$type}",
                    ],
                ];
            if ($type === 'brick_column') {
                $jsonData['fabric:conditions'][] = $columnLoadedCondition;
            }
            file_put_contents("{$dataPath}/{$modId}/recipes/color_{$color}_{$type}.json", json_encode($jsonData, $jsonOptions));

            $jsonData = [
                    'type' => 'minecraft:crafting_shapeless',
                    'group' => "color_{$type}",
                    'ingredients' => [
                        $brickIngredients,
                        $brickIngredients,
                        $brickIngredients,
                        $brickIngredients,
                        $dyeIngredients,
                        $brickIngredients,
                        $brickIngredients,
                        $brickIngredients,
                        $brickIngredients,
                    ],
                    'result' => [
                        'count' => 8,
                        'item' => "{$modId}:{$color}_{$type}",
                    ],
                ];
            if ($type === 'brick_column') {
                $jsonData['fabric:conditions'][] = $columnLoadedCondition;
            }
            file_put_contents("{$dataPath}/{$modId}/recipes/color8_{$color}_{$type}.json", json_encode($jsonData, $jsonOptions));

            $jsonData = [
                    'type' => 'minecraft:stonecutting',
                    'ingredient' => [
                        'item' => "{$modId}:{$color}_bricks",
                    ],
                    'result' => "{$modId}:{$color}_{$type}",
                    'count' => match ($type) {
                        'brick_slab' => 2,
                        'bricks' => 0,
                        default => 1
                    }
                ];
            if ($type === 'brick_column') {
                $jsonData['fabric:conditions'][] = $columnLoadedCondition;
            }
            if ($jsonData['count']) {
                file_put_contents("{$dataPath}/{$modId}/recipes/{$color}_{$type}_from_bricks_stonecutting.json", json_encode($jsonData, $jsonOptions));
            }

            $craftCount = match ($type) {
                'brick_column',
                'brick_slab',
                'brick_wall' => 6,

                'brick_stairs' => 4,

                'bricks' => null,
            };

            if ($craftCount) {
                $jsonData = [
                    'type' => 'minecraft:crafting_shaped',
                    'pattern' => match ($type) {
                        'brick_column' => ['###', ' # ', '###'],
                        'brick_slab' => ['###'],
                        'brick_stairs' => ['#  ', '## ', '###'],
                        'brick_wall' => ['###', '###'],
                        // Not possible
                        'bricks' => null,
                    },
                    'key' => [
                        '#' => [
                            'item' => "{$modId}:{$color}_bricks",
                        ],
                    ],
                    'result' => [
                        'item' => "{$modId}:{$color}_{$type}",
                        'count' => $craftCount,
                    ],
                ];
                if ($type === 'brick_column') {
                    $jsonData['fabric:conditions'][] = $columnLoadedCondition;
                }

                file_put_contents("{$dataPath}/{$modId}/recipes/{$color}_{$type}.json", json_encode($jsonData, $jsonOptions));
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Loot Tables">
    foreach ($colors as $color) {
        foreach ($types as $type) {
            $jsonData = [
                'type' => 'minecraft:block',
                'pools' => [
                    [
                        'rolls' => 1,
                        'entries' => [
                            [
                                'type' => 'minecraft:item',
                                'name' => "{$modId}:{$color}_{$type}",
                            ],
                        ],
                        'conditions' => [
                            [
                                'condition' => 'minecraft:survives_explosion',
                            ],
                        ],
                    ],
                ],
            ];
            if ($type === 'brick_column') {
                $jsonData['fabric:conditions'][] = $columnLoadedCondition;
            }
            file_put_contents(
                "{$dataPath}/{$modId}/loot_tables/blocks/{$color}_{$type}.json",
                json_encode($jsonData, $jsonOptions),
            );
        }
    }
    //</editor-fold>

    //<editor-fold desc="Assets blockstates">
    foreach ($colors as $color) {
        $jsons = [
            'bricks' => [
                'variants' => [
                    '' => [
                        'model' => "{$modId}:block/{$color}_bricks",
                    ],
                ],
            ],

            'brick_column' => [
                'multipart' => [
                    [
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_column_center",
                        ],
                    ],
                    [
                        'when' => [
                            'down' => true,
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_column_end",
                        ],
                    ],
                    [
                        'when' => [
                            'up' => true,
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_column_end",
                            'x' => 180,
                            'uvlock' => true,
                        ],
                    ],
                ],
            ],

            'brick_slab' => [
                'variants' => [
                    'type=bottom' => [
                        'model' => "{$modId}:block/{$color}_brick_slab",
                    ],
                    'type=top' => [
                        'model' => "{$modId}:block/{$color}_brick_slab_top",
                    ],
                    'type=double' => [
                        'model' => "{$modId}:block/{$color}_bricks",
                    ],
                ],
            ],

            'brick_stairs' => [
                'variants' => [
                    'facing=east,half=bottom,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                    ],
                    'facing=west,half=bottom,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=bottom,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=bottom,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=east,half=bottom,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                    ],
                    'facing=west,half=bottom,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=bottom,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=bottom,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=east,half=bottom,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=west,half=bottom,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=south,half=bottom,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                    ],
                    'facing=north,half=bottom,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=east,half=bottom,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                    ],
                    'facing=west,half=bottom,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=bottom,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=bottom,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=east,half=bottom,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=west,half=bottom,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=south,half=bottom,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                    ],
                    'facing=north,half=bottom,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=east,half=top,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'x' => 180,
                        'uvlock' => true,
                    ],
                    'facing=west,half=top,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'x' => 180,
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=top,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'x' => 180,
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=top,shape=straight' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs",
                        'x' => 180,
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=east,half=top,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=west,half=top,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=south,half=top,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=north,half=top,shape=outer_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'uvlock' => true,
                    ],
                    'facing=east,half=top,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'uvlock' => true,
                    ],
                    'facing=west,half=top,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=top,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=top,shape=outer_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_outer",
                        'x' => 180,
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=east,half=top,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=west,half=top,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 270,
                        'uvlock' => true,
                    ],
                    'facing=south,half=top,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=north,half=top,shape=inner_right' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'uvlock' => true,
                    ],
                    'facing=east,half=top,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'uvlock' => true,
                    ],
                    'facing=west,half=top,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 180,
                        'uvlock' => true,
                    ],
                    'facing=south,half=top,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 90,
                        'uvlock' => true,
                    ],
                    'facing=north,half=top,shape=inner_left' => [
                        'model' => "{$modId}:block/{$color}_brick_stairs_inner",
                        'x' => 180,
                        'y' => 270,
                        'uvlock' => true,
                    ],
                ],
            ],

            'brick_wall' => [
                'multipart' => [
                    [
                        'when' => [
                            'up' => 'true',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_post",
                        ],
                    ],
                    [
                        'when' => [
                            'north' => 'low',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side",
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'east' => 'low',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side",
                            'y' => 90,
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'south' => 'low',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side",
                            'y' => 180,
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'west' => 'low',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side",
                            'y' => 270,
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'north' => 'tall',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side_tall",
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'east' => 'tall',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side_tall",
                            'y' => 90,
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'south' => 'tall',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side_tall",
                            'y' => 180,
                            'uvlock' => true,
                        ],
                    ],
                    [
                        'when' => [
                            'west' => 'tall',
                        ],
                        'apply' => [
                            'model' => "{$modId}:block/{$color}_brick_wall_side_tall",
                            'y' => 270,
                            'uvlock' => true,
                        ],
                    ],
                ],
            ],
        ];

        foreach ($jsons as $type => $jsonData) {
            file_put_contents(
                "{$assetsPath}/{$modId}/blockstates/{$color}_{$type}.json",
                json_encode(
                    $jsonData,
                    $jsonOptions,
                ),
            );
        }
    }
    //</editor-fold>

    //<editor-fold desc="Assets Items">
    foreach ($colors as $color) {
        $jsons = [
            'bricks' => [
                'parent' => "{$modId}:block/{$color}_bricks",
            ],

            'brick_column' => [
                'parent' => "{$modId}:block/{$color}_brick_column_inventory",
            ],

            'brick_slab' => [
                'parent' => "{$modId}:block/{$color}_brick_slab",
            ],

            'brick_stairs' => [
                'parent' => "{$modId}:block/{$color}_brick_stairs",
            ],

            'brick_wall' => [
                'parent' => "{$modId}:block/{$color}_brick_wall_inventory",
            ],
        ];

        foreach ($jsons as $type => $jsonData) {
            file_put_contents(
                "{$assetsPath}/{$modId}/models/item/{$color}_{$type}.json",
                json_encode(
                    $jsonData,
                    $jsonOptions,
                ),
            );
        }
    }
    //</editor-fold>

    //<editor-fold desc="Assets Blocks">
    foreach ($colors as $color) {
        $jsons = [
            'brick_column_center' => [
                'parent' => 'columns:block/column_center',
                'textures' => [
                    'all' => "{$modId}:block/{$color}_bricks",
                ],
            ],

            'brick_column_end' => [
                'parent' => 'columns:block/column_end',
                'textures' => [
                    'all' => "{$modId}:block/{$color}_bricks",
                ],
            ],

            'brick_column_inventory' => [
                'parent' => 'columns:block/column_inventory',
                'textures' => [
                    'all' => "{$modId}:block/{$color}_bricks",
                ],
            ],

            'brick_slab' => [
                    'parent' => 'block/slab',
                    'textures' => [
                        'bottom' => "{$modId}:block/{$color}_bricks",
                        'top' => "{$modId}:block/{$color}_bricks",
                        'side' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_slab_top' => [
                    'parent' => 'block/slab_top',
                    'textures' => [
                        'bottom' => "{$modId}:block/{$color}_bricks",
                        'top' => "{$modId}:block/{$color}_bricks",
                        'side' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_stairs' => [
                    'parent' => 'block/stairs',
                    'textures' => [
                        'bottom' => "{$modId}:block/{$color}_bricks",
                        'top' => "{$modId}:block/{$color}_bricks",
                        'side' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_stairs_inner' => [
                    'parent' => 'block/inner_stairs',
                    'textures' => [
                        'bottom' => "{$modId}:block/{$color}_bricks",
                        'top' => "{$modId}:block/{$color}_bricks",
                        'side' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_stairs_outer' => [
                    'parent' => 'block/outer_stairs',
                    'textures' => [
                        'bottom' => "{$modId}:block/{$color}_bricks",
                        'top' => "{$modId}:block/{$color}_bricks",
                        'side' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_wall_inventory' => [
                'parent' => 'block/wall_inventory',
                'textures' => [
                    'wall' => "{$modId}:block/{$color}_bricks",
                ],
            ],

            'brick_wall_post' => [
                'parent' => 'block/template_wall_post',
                'textures' => [
                    'wall' => "{$modId}:block/{$color}_bricks",
                ],
            ],

            'brick_wall_side' => [
                    'parent' => 'block/template_wall_side',
                    'textures' => [
                        'wall' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'brick_wall_side_tall' => [
                    'parent' => 'minecraft:block/template_wall_side_tall',
                    'textures' => [
                        'wall' => "{$modId}:block/{$color}_bricks",
                    ],
                ],

            'bricks' => [
                'parent' => 'minecraft:block/cube_all',
                'textures' => [
                    'all' => "{$modId}:block/{$color}_bricks",
                ],
            ],
        ];

        foreach ($jsons as $type => $jsonData) {
            file_put_contents("{$assetsPath}/{$modId}/models/block/{$color}_{$type}.json", json_encode($jsonData, $jsonOptions));
        }
    }
    //</editor-fold>
})();
