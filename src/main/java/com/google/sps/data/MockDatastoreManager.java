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

public class MockDatastoreManager {
    public void storeUser(User user) {}
    public void updateUser(User user) {}
    /**
    * Returns a mock user.
    * @param userID a string containing a userID. The userID of the mock user will be set to this.
    * @return a User object.
    */
    public User retrieveUser(String userID) {
        User.Builder userBuilder = new User.Builder(userID);
        userBuilder.setUsername("username");
        userBuilder.setFirstName("Firstname");
        userBuilder.setLastName("Lastname");
        userBuilder.setProfilePictureUrl("images/defaultProfilePicture.jpg");
        userBuilder.setGamesCreated(new ArrayList<String>());
        userBuilder.setGamesCompletedWithTime(new ArrayList<Pair<String, Long>>());
        return userBuilder.build();
    }

    public void storeGame(Game game) {}
    public void updateGame(Game game) {}

    /**
    * Returns the demo game.
    * @param gameID a string containing a gameID. This is ignored because this is a mock.
    * @return a Game object with the data of the demo game.
    */
    public Game retrieveGame(String gameID) {
        Game.Builder gameBuilder = new Game.Builder(gameID, "Demo");
        gameBuilder.setGameCreator("usernameid12345");
        gameBuilder.setGameDescription("Demo game for testing");
        ArrayList<String> stages = new ArrayList<String>();
        stages.add("stage1id");
        stages.add("stage2id");
        gameBuilder.setStages(stages);
        return gameBuilder.build();
    }

    public void storeStage(Stage stage) {}
    public void updateStage(Stage stage) {}

    /**
    * Returns a stage of the demo game.
    * @param stageID a string containing the stageID. This method will
    *                return stage 1 if stageID = "stage1id" and stage 2
    *                otherwise.
    * @return a Stage object with the data of the requested stage.
    */
    public Stage retrieveStage(String stageID) {
        int idx = -1;
        if(stageID.equals("stage1id")) {
            idx = 1;
        } else {
            idx = 2;
        }
        Stage stage = getStage(stageID, idx);
        return stage;
    }

    public void storeSingleplayerProgress(SingleplayerProgress progress) {}
    public void updateSingleplayerProgress(SingleplayerProgress progress) {}
    public SingleplayerProgress retrieveSingleplayerProgress(String userID, String gameID) {
        return null;
    }

    private Stage getStage(String stageID, int idx) {
        if(idx == 1) {
            Stage.Builder stageBuilder = new Stage.Builder(stageID, 1);
            stageBuilder.setKey("mellon");
            stageBuilder.setStartingHint("Look for the people who defy gravity");
            stageBuilder.setStartingLocation(new Coordinates(40.444240, -79.942013));
            ArrayList<Hint> hints = new ArrayList<Hint>();
            for(int i = 1; i <= 6; i++) hints.add(getHint(i));
            stageBuilder.setHints(hints);
            return stageBuilder.build();
        } else {
            Stage.Builder stageBuilder = new Stage.Builder(stageID, 2);
            stageBuilder.setKey("test");
            stageBuilder.setStartingHint("Testing multiple stages");
            stageBuilder.setStartingLocation(new Coordinates(33.748439, -84.415932));
            ArrayList<Hint> hints = new ArrayList<Hint>();
            Hint.Builder h = new Hint.Builder("stage2hint", 1);
            h.setLocation(new Coordinates(33.748530, -84.414718));
            h.setText("The key is 'test'");
            hints.add(h.build());
            stageBuilder.setHints(hints);
            return stageBuilder.build();
        }
    }

    private Hint getHint(int idx) {
        Hint.Builder res = new Hint.Builder("hint" + String.valueOf(idx) + "id", idx);
        if(idx == 1) {
            res.setLocation(new Coordinates(40.444155, -79.942854));
            res.setText("I need a break from all of this dra[m]a.");
        } else if(idx == 2) {
            res.setLocation(new Coordinates(40.443132, -79.943448));
            res.setText("Why is ther[e] so much paint on this?!");
        } else if(idx == 3) {
            res.setLocation(new Coordinates(40.442228, -79.943445));
            res.setText("Face south, then keep following the rightmost path unti[l] you reach a turtle-shaped building.");
        } else if(idx == 4) {
            res.setLocation(new Coordinates(40.442396, -79.945995));
            res.setText("Nada[l] would want to be here.");
        } else if(idx == 5) {
            res.setLocation(new Coordinates(40.442084, -79.942227));
            res.setText("How is this a r[o]tunda with no dome?");
        } else if(idx == 6) {
            res.setLocation(new Coordinates(40.441847, -79.941526));
            res.setText("This is the final hint, [n]ow please enter the key.");
        }
        return res.build();
    }
}