import React, { useState } from 'react';
import { NavLink, useNavigate } from 'react-router-dom';

const HeaderComponent = () => {
  const [searchType, setSearchType] = useState('employees'); // Default to searching employees
  const [searchQuery, setSearchQuery] = useState('');
  const navigate = useNavigate();

  const handleSearch = () => {
    if (searchQuery.trim()) {
      // Redirect to the appropriate route with the search query
      navigate(`/${searchType}?search=${encodeURIComponent(searchQuery)}`);
    }
  };

  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <a className="navbar-brand display-4" href="/">
            <img
              src="/src/assets/headerlogo.svg"
              alt="Avatar Logo"
              width="49"
              height="30"
              className="d-inline-block align-text-top"
            />{' '}
            Employees & Departments Management Application
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav me-auto">
              <li className="nav-item">
                <NavLink className="nav-link" to="/employees">
                  Employees
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/departments">
                  Departments
                </NavLink>
              </li>
            </ul>

            {/* Search Section */}
            <div className="d-flex">
              <select
                className="form-select me-2"
                value={searchType}
                onChange={(e) => setSearchType(e.target.value)}
                style={{ width: '150px' }}
              >
                <option value="employees">Employees</option>
                <option value="departments">Departments</option>
              </select>
              <input
                className="form-control me-2"
                type="search"
                placeholder={`Search ${searchType}`}
                aria-label="Search"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
              />
              <button className="btn btn-outline-light" onClick={handleSearch}>
                Search
              </button>
            </div>
          </div>
        </nav>
      </header>
    </div>
  );
};

export default HeaderComponent;