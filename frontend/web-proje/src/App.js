import './App.css';
import Login from './pages/Login';
import 'bootstrap/dist/css/bootstrap.min.css'
import Home from './pages/Home'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import { ToastContainer, toast } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';
import UsersPage from './pages/UsersPage';
import Register from './pages/Register';
function App() {
  return (
    <Router>
      <ToastContainer/>
      <div className="App" >
        <Switch>
          <Route exact path="/">
            <Login />
          </Route>

          <Route exact path="/Home">
            <Home />
          </Route>

          <Route exact path="/Users">
            <UsersPage></UsersPage>
          </Route>

          <Route exact path="/Register">
            <Register></Register>
          </Route>
          {/* <Route exact path = "/BookKeep">
                <Home/>
              </Route> */}

        </Switch>

      </div>
    </Router>
  );
}

export default App;
