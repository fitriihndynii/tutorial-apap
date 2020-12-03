import React from "react";

import List from "components/List";
import listMovies from "movies.json";
import "./App.css";
import {Switch} from "antd";


export default class App extends React.Component{
  state = {
    favItems: [],
    checked: false
  };

  constructor(){
    super()
    this.handleChange = this.handleChange.bind(this)
  };

  handleChange(checked){
    this.setState({checked: checked})
  };

  handleItemClick = (item) => {
    // Immutability
    const newItems =  [ ...this.state.favItems];
    const newItem = { ...item };
    // Find item index using id
    const targetInd = newItems.findIndex((it) => it.id === newItem.id);

    if (targetInd < 0) newItems.push(newItem);
    // else newItems.splice(targetInd, 1); //Delete 1 item at index targetInd

    // Trigger set state
    this.setState({ favItems: newItems })
  };

  deleteFavorit = (item) => {
    this.setState({ favItems: []});
  };

  render(){
    const { favItems } = this.state;
    return(
      <div className ="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favourites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className ="text-center container-fluid align-items-center">
        <Switch
            className ="react-switch"
            onChange={this.handleChange}
            checked = {this.state.checked}
          /> <strong>Show Favorites</strong>
          </div>
          <div className="container pt-3">
            <b> {this.state.checked ?
            <div className="row">
              <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClick}
                />
              </div>
              <div className="col-sm">
                <List 
                  title="My Favorites"
                  items={favItems}
                  onItemClick={this.handleItemClick}
                  />
                  {this.state.favItems.length > 0 &&  <button type="buttton" onClick={this.deleteFavorit}>Delete All Favorites</button>}
              </div>
            </div>
            : <div className="row">
                <List
                  title="List Movies"
                  items={listMovies}
                  onItemClick={this.handleItemClick}
                  />
              </div>}
            </b>
        </div>
      </div>
    )
  }
}

