// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

import java.util.ArrayList;

/**
* Represents the static data of a single game.
*/
public class Game {
    private final String gameID;
    private final String gameName;
    private final String gameCreator;
    private final String gameDescription;
    private final int numStages;
    private final ArrayList<String> stages;
    private final int numTimesPlayed;
    private final int numTimesFinished;
    private final int numStarVotes;
    private final int totalStars;
    private final int numDifficultyVotes;
    private final int totalDifficulty;

    /**
    * Builder class used to create Game objects.
    */
    public static class Builder {
        // Required parameters
        private final String gameID;
        private final String gameName;

        // Optional paramters - initialized to default values
        private String gameCreator = null;
        private String gameDescription = null;
        private int numStages = -1;
        private ArrayList<String> stages = null;
        private int numTimesPlayed = -1;
        private int numTimesFinished = -1;
        private int numStarVotes = -1;
        private int totalStars = -1;
        private int numDifficultyVotes = -1;
        private int totalDifficulty = -1;

        /**
        * Constructor that sets the game ID and the game name.
        * @param gameID the unique code used to identify this specific game.
        * @param gameName a string representing the game's name.
        */
        public Builder(String gameID, String gameName) {
            this.gameID = gameID;
            this.gameName = gameName;
        }

        /**
        * Sets the game's creator, which is displayed on the game's page.
        * @param val a String representing the creator's username.
        * @return a Builder object with the modified creator.
        */
        public Builder setGameCreator(String val) {
            this.gameCreator = val;
            return this;
        }

        /**
        * Sets the game's description, which is displayed on the game's page.
        * @param val a String representing the new description.
        * @return a Builder object with the modified description.
        */
        public Builder setGameDescription(String val) {
            this.gameDescription = val;
            return this;
        }
        
        /**
        * Sets the number of stages in the game.
        * @param val an int representing the number of stages.
        * @return a Builder object with the modified number of stages.
        */
        public Builder setNumStages(int val) {
            this.numStages = val;
            return this;
        }

        /**
        * Specifies which stages are in the game.
        * @param val an ArrayList of String representing the list of stages in the game.
        *            Each stage is represented by its ID.
        * @return a Builder object with the modified list of stages.
        */
        public Builder setStages(ArrayList<String> val) {
            this.stages = val;
            return this;
        }

        /**
        * Sets the number of times the game has been played.
        * @param val an int representing the number of times the game has been played.
        * @return a Builder object with the modified number of times played.
        */
        public Builder setNumTimesPlayed(int val) {
            this.numTimesPlayed = val;
            return this;
        }

        /**
        * Sets the number of times the game has been played to completion.
        * @param val an int representing the number of times this game has been finished.
        * @return a Builder object with the modified number of times finished.
        */
        public Builder setNumTimesFinished(int val) {
            this.numTimesFinished = val;
            return this;
        }

        /**
        * Sets the number of times this game's number of stars has been voted on.
        * @param val an int representing the number of times this game's number of stars has been voted on.
        * @return a Builder object with the modified number of star votes.
        */
        public Builder setNumStarVotes(int val) {
            this.numStarVotes = val;
            return this;
        }

        /**
        * Sets the total number of stars this game has received.
        * @param val an int representing the total number of stars this game has received.
        * @return a Builder object with the modified total number of stars.
        */
        public Builder setTotalStars(int val) {
            this.totalStars = val;
            return this;
        }

        /**
        * Sets the number of times this game's difficulty has been voted on.
        * @param val an int representing the number of times this game's difficulty has been voted on.
        * @return a Builder object with the modified number of difficulty votes.
        */
        public Builder setNumDifficultyVotes(int val) {
            this.numDifficultyVotes = val;
            return this;
        }

        /**
        * Sets the sum of all difficulty votes received by this game (1 = Easy, 2 = Medium, 3 = Hard).
        * @param val an int representing the total sum of difficulty votes.
        * @return a Builder object with the modified total difficulty.
        */
        public Builder setTotalDifficulty(int val) {
            this.totalDifficulty = val;
            return this;
        }

        /**
        * Gets the Game object created by this Builder.
        * @return a Game object with the properties specified in the Builder.
        */
        public Game build() {
            return new Game(this);
        }
    }
    
    /**
    * Constructor that converts a Builder into a Game.
    * @param builder the Builder object to be converted.
    * @see Builder#build()
    */
    private Game(Builder builder) {
        this.gameID = builder.gameID;
        this.gameName = builder.gameName;
        this.gameCreator = builder.gameCreator;
        this.gameDescription = builder.gameDescription;
        this.numStages = builder.numStages;
        this.stages = builder.stages;
        this.numTimesPlayed = builder.numTimesPlayed;
        this.numTimesFinished = builder.numTimesFinished;
        this.numStarVotes = builder.numStarVotes;
        this.totalStars = builder.totalStars;
        this.numDifficultyVotes = builder.numDifficultyVotes;
        this.totalDifficulty = builder.totalDifficulty;
    }

    /**
    * Retrieves the game ID.
    * @return a String representing the gameID of this Game.
    */
    public String getGameID() {
        return this.gameID;
    }

    /**
    * Retrieves the game name.
    * @return a String representing the gameName of this Game.
    */
    public String getGameName() {
        return this.gameName;
    }

    /**
    * Retrieves the game's creator.
    * @return a String representing the userID of the creator of this game.
    */
    public String getGameCreator() {
        return this.gameCreator;
    }

    /**
    * Retrieves the game's description.
    * @return a String representing the description of this game.
    */
    public String getGameDescription() {
        return this.gameDescription;
    }

    /**
    * Retrieves the number of stages this game has.
    * @return an int representing how many stages this game has.
    */
    public int getNumStages() {
        return this.numStages;
    }

    /**
    * Retrieves the list of stages in this game.
    * @return an ArrayList of String representing the stageIDs of the stages in this game.
    */
    public ArrayList<String> getStages() {
        return this.stages;
    }

    /**
    * Retrieves the number of times this game has been played.
    * @return an int representing how many times this game has been played.
    */
    public int getNumTimesPlayed() {
        return this.numTimesPlayed;
    }

    /**
    * Retrieves the number of times this game has been finished (won).
    * @return an int representing how many times this game has been finished.
    */
    public int getNumTimesFinished() {
        return this.numTimesFinished;
    }

    /**
    * Retrieves the number of times this game's number of stars has been voted on.
    * @return an int representing the number of times this game's number of stars has been voted on.
    */
    public int getNumStarVotes() {
        return this.numStarVotes;
    }

    /**
    * Retrieves the number of stars this game has received.
    * @return an int representing how many stars this game has received.
    */
    public int getTotalStars() {
        return this.totalStars;
    }

    /**
    * Retrives the number of times this game's difficulty has been voted on.
    * @return an int representing the number of times this game's difficulty has been voted on.
    */
    public int getNumDifficultyVotes() {
        return this.numDifficultyVotes;
    }

    /**
    * Retrieves the sum of all difficulty votes received by this game (1 = Easy, 2 = Medium, 3 = Hard).
    * @return an int representing the sum of all difficulty votes received by this game.
    */
    public int getTotalDifficulty() {
        return this.totalDifficulty;
    }
}
