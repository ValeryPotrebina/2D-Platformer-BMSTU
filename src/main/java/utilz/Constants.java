package utilz;

public class Constants {

    public static final class GameWindowConstants {
        public final static int FPS_SET = 120;
        public final static int UPS_SET = 200;

        public final static int TILE_SIZE_DEFAULT = 32;
        public final static int TILES_IN_WIDTH = 32;
        public final static int TILES_IN_HEIGHT = 16;

        public final static int GAME_WIDTH_DEFAULT = TILE_SIZE_DEFAULT * TILES_IN_WIDTH;
        public final static int GAME_HEIGHT_DEFAULT = TILE_SIZE_DEFAULT * TILES_IN_HEIGHT;

    }

    public static class GameConstants {
        public final static float GRAVITY = 0.035f;
        public static final float ANI_SPEED = 25;

    }

    public static class UI {
        public static class Button {
            public static final int ON = 0;
            public static final int OVER = 1;
            public static final int PRESSED = 2;
        }

        public static class MenuButtons {
            public static final int COUNT_BUTTONS = 1;

            public static final int PLAY = 0;
            public static final int OPTIONS = 1;
            public static final int QUIT = 2;

            public static final int BUTTON_WIDTH_DEFAULT = 140;
            public static final int BUTTON_HEIGHT_DEFAULT = 56;
        }

//        public static class PauseSoundButtons {
//            public static final int MUTED_OFF = 0;
//            public static final int MUTED_ON = 1;
//
//            public static final int PAUSE_SOUND_POS_X = (int) (450 * SCALE);
//            public static final int PAUSE_SOUND_MUSIC_POS_Y = (int) (140 * SCALE);
//            public static final int PAUSE_SOUND_SFX_POS_Y = (int) (186 * SCALE);
//
//            public static final int SOUND_SIZE_DEFAULT = 42;
//            public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * SCALE);
//        }
//        public static class PauseURMButtons {
//            public static final int URM_PLAY = 0;
//            public static final int URM_REPLAY = 1;
//            public static final int URM_MENU = 2;
//
//            public static final int PAUSE_URM_MENU_POS_X = (int) (313 * SCALE);
//            public static final int PAUSE_URM_REPLAY_POS_X = (int) (387 * SCALE);
//            public static final int PAUSE_URM_PLAY_POS_X = (int) (462 * SCALE);
//            public static final int PAUSE_URM_POS_Y = (int) (325 * SCALE);
//
//            public static final int URM_DEFAULT_SIZE = 56;
//            public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * SCALE);
//        }
//        public static class PauseVolumeButtons {
//            public static final int PAUSE_VOLUME_POS_X = (int) (309 * SCALE);
//            public static final int PAUSE_VOLUME_POS_Y = (int) (278 * SCALE);
//
//            public static final int VOLUME_WIDTH_DEFAULT = 28;
//            public static final int VOLUME_HEIGHT_DEFAULT = 44;
//            public static final int SLIDER_WIDTH_DEFAULT = 215;
//            public static final int VOLUME_WIDTH = (int) (VOLUME_WIDTH_DEFAULT * SCALE);
//            public static final int VOLUME_HEIGHT = (int) (VOLUME_HEIGHT_DEFAULT * SCALE);
//            public static final int SLIDER_WIDTH = (int) (SLIDER_WIDTH_DEFAULT * SCALE);
//        }

//        public static class PositionButtons {
//            public static final int COMPLETE_URM_MENU_POS_X = (int) (330 * SCALE);
//            public static final int COMPLETE_URM_PLAY_POS_X = (int) (445 * SCALE);
//            public static final int COMPLETE_URM_POS_Y = (int) (195 * SCALE);
//
//            public static final int GAME_OVER_URM_MENU_POS_X = (int) (335 * SCALE);
//            public static final int GAME_OVER_URM_PLAY_POS_X = (int) (440 * SCALE);
//            public static final int GAME_OVER_URM_POS_Y = (int) (195 * SCALE);
//        }

    }

    public static final class LvlConstants {
//        public static class Environment {
//            public static final int BIG_CLOUD_WIDTH_DEFAULT = 448;
//            public static final int BIG_CLOUD_HEIGHT_DEFAULT = 101;
//            public static final int SMALL_CLOUD_WIDTH_DEFAULT = 74;
//            public static final int SMALL_CLOUD_HEIGHT_DEFAULT = 24;
//
//            public static final int BIG_CLOUD_WIDTH = (int) (BIG_CLOUD_WIDTH_DEFAULT * SCALE);
//            public static final int BIG_CLOUD_HEIGHT = (int) (BIG_CLOUD_HEIGHT_DEFAULT * SCALE);
//            public static final int SMALL_CLOUD_WIDTH = (int) (SMALL_CLOUD_WIDTH_DEFAULT * SCALE);
//            public static final int SMALL_CLOUD_HEIGHT = (int) (SMALL_CLOUD_HEIGHT_DEFAULT * SCALE);
//
//            public static final float SPEED_BIG_CLOUDS = 0.3f;
//            public static final float SPEED_SMALL_CLOUDS = 0.7f;
//        }
    }
    public static class PlayerConstants {
//        public static final int IDLE = 0;
//        public static final int RUNNING = 1;
//        public static final int JUMP = 2;
//        public static final int FALLING = 3;
//        public static final int ATTACK = 4;
//        public static final int HIT = 5;
//        public static final int DEAD = 6;
//
//        public static int GetSpriteAmount(int player_action) {
//
//            switch (player_action) {
//                case DEAD: return 8;
//                case RUNNING: return 6;
//                case IDLE: return 5;
//                case HIT: return 4;
//                case JUMP:
//                case ATTACK:
//                    return 3;
//                case FALLING:
//                default:
//                    return 1;
//            }
//        }
    }


    public static final class TextureConstants {
        public static final class Menu {
            public static final String MENU_LOCATION_TEXTURES = "menu";

            public static final String MENU_ATLAS_PNG = "menu_atlas.png";
            public static final String MENU_BACKGROUND_PNG = "menu_background.png";
            public static final String MENU_BUTTONS_PNG = "menu_buttons.png";
        }
        public static final class Options {
//            public static final String OPTIONS_BACKGROUND_PNG = "options_background.png";

        }

        public static final class Pause {
//            public static final String PAUSE_BACKGROUND_PNG = "pause_background.png";
//            public static final String PAUSE_SOUND_BUTTON_PNG = "pause_sound_buttons.png";
//            public static final String PAUSE_URM_BUTTON_PNG = "pause_urm_buttons.png";
//            public static final String PAUSE_VOLUME_BUTTON_PNG = "pause_volume_buttons.png";
        }

        public static final class Complete {
//            public static final String COMPLETE_BACKGROUND_PNG = "complete_background.png";
        }

        public static final class GameOver {
//            public static final String GAME_OVER_BACKGROUND_PNG = "game_over_background.png";
        }

        public static final class Level {
            public static final String LEVEL_LOCATION_TEXTURES = "level";
            public static final String LVL_TEXTURES_PNG = "lvl_textures.png";
//            public static final String LVL_BACKGROUND_PNG = "lvl_background.png";
//            public static final String LVL_CLOUDS_BIG_PNG = "lvl_clouds_big.png";
//            public static final String LVL_CLOUDS_SMALL_PNG = "lvl_clouds_small.png";

        }

        public static final class Player {
//            public static final String PLAYER_SPRITES_PNG = "player_sprites.png";
        }

    }

}
