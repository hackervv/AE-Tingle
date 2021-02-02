import React from 'react';
import logo from './logo.svg';
import {Admin, Resource, ListGuesser} from 'react-admin'
import {Layout, Login} from './layout'
import jsonServerProvider from 'ra-data-json-server';
import customRoutes from './routes';
import './App.css';
import authProvider from './authProvider';
import themeReducer from './themeReducer';
import {Dashboard} from './dashboard';

function App() {
  const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');
  return (
    <Admin
      title="AE Tingle Admin Site"
      dataProvider={dataProvider}
      authProvider={authProvider}
      customRoutes={customRoutes}
      dashboard={Dashboard}
      customReducers={{theme: themeReducer}}
      loginPage={Login}
      layout={Layout}
    >
      <Resource name="users" list={ListGuesser} />
    </Admin>
  );
}

export default App;
