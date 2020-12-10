import React, { useState } from "react";

import List from "./components/List";
import Empty from "./components/EmptyState";
import listMovies from "movies.json";
import "./App.css";
import {Switch} from "antd";


/**
 * Building React component using functional programming paradigm
*/

function App() {
    const [favItems, setFavItems] = useState(() => []);
    const [checked, setChecked]  = useState(()=> false);
    function handleChange(checked){
        setChecked(checked);
    }
    function handleItemClick(item) {
        //immutability
        const newItems = [...favItems];
        const newItem = { ...item };

        //Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);

        if (targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1); // delete 1 item at index targetInd

        //trigger to set a new state
        setFavItems(newItems);
    }
    function handleAddFav(item) {
        //immutability
        const newItems = [...favItems];
        const newItem = { ...item };

        //Find index of item with id
        const targetInd = newItems.findIndex(it => it.id === newItem.id);

        if (targetInd < 0) newItems.push(newItem);
        // else newItems.splice(targetInd, 1); // delete 1 item at index targetInd

        //trigger to set a new state
        setFavItems(newItems);
    }
    function deleteListFavorites(){
        setFavItems([]);
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
                (This is a <strong>function-based</strong> application)
            </p>
            <div className ="text-center container-fluid align-items-center">
                <Switch
                    className ="react-switch"
                    onChange={handleChange}
                    checked = {checked}
                /><p><strong>Show Favorites</strong></p>
            </div>
            <div className="container pt-3">
          <b> {checked ? 
            <div className="row">
                <div className="col-sm">
                  <List
                    title="List Movies"
                    items={listMovies}
                    onItemClick={handleAddFav}
                    />
                </div>
                <div className="col-sm">
                  <List 
                    title="My Favorites"
                    items={favItems}
                    onItemClick={handleItemClick}
                    />
                    {favItems.length > 0 &&  <button type="buttton" onClick={deleteListFavorites}>Delete All Favorites</button> }  
                    {favItems.length==0 && <Empty></Empty>} 
                </div>
              </div>
                  :
                    <div className="row">
                      <List
                        title="List Movies"
                        items={listMovies}
                        onItemClick={handleAddFav}
                        />
                    </div>    }
            </b>       
        </div>
            {/* <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={handleAddItem}
                        />
                    </div>
                    <div className="col-sm">
                        <List
                            title="My Favorites"
                            items={favItems}
                            onItemClick={handleItemClick}
                        />
                         {favItems.length > 0 &&  <button type="buttton" onClick={deleteAll}>Delete All Favorites</button> }  
                         {favItems.length==0 && <Empty></Empty>} 

                    </div>
                </div>
            </div> */}
        </div>
    );
}

export default App;