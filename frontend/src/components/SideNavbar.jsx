import React from "react";
import {
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Box
} from "@mui/material";

import DashboardIcon from "@mui/icons-material/Dashboard";
import PeopleIcon from "@mui/icons-material/People";

import { useNavigate } from "react-router-dom";

const drawerWidth = 240;

const SideNavbar = () => {

  const navigate = useNavigate();

  const menuItems = [
    {
      text: "Dashboard",
      icon: <DashboardIcon />,
      path: "/dashboard"
    },
    {
      text: "Empleados",
      icon: <PeopleIcon />,
      path: "/empleados"
    }
  ];

  return (
    <Drawer
      variant="permanent"
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        '& .MuiDrawer-paper': {
          width: drawerWidth,
          boxSizing: 'border-box'
        },
      }}
    >
      <Box sx={{ overflow: "auto" }}>
        <List>
          {menuItems.map((item, index) => (
            <ListItem key={index} disablePadding>
              <ListItemButton onClick={() => navigate(item.path)}>
                
                <ListItemIcon>
                  {item.icon}
                </ListItemIcon>

                <ListItemText primary={item.text} />

              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Box>
    </Drawer>
  );
};

export default SideNavbar;