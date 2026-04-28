import React from "react";
import {
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Box,
  useTheme,
  useMediaQuery,
  Toolbar,
  patch
} from "@mui/material";

import DashboardIcon from "@mui/icons-material/Dashboard";
import PeopleIcon from "@mui/icons-material/People";
import BusinessIcon from "@mui/icons-material/Business";
import AddOutlinedIcon from '@mui/icons-material/AddOutlined';

import { useNavigate } from "react-router-dom";

const drawerWidth = 240;

const SideNavbar = ({ mobileOpen, handleDrawerToggle }) => {

  const navigate = useNavigate();

  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down("md"));

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
    },

    {
    text: "crear empresa",
    icon: <AddOutlinedIcon />,
    path:"/empresas/Crear"
    },

    {
      text: "Consultar empresa",
      icon: <BusinessIcon />,
      path:"/empresas"
    }

  ];

  const drawerContent = (
    <Box>
      <Toolbar />

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
    </Box>
  );

  return (
    <Drawer
      variant={isMobile ? "temporary" : "permanent"}
      open={isMobile ? mobileOpen : true}
      onClose={handleDrawerToggle}
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        '& .MuiDrawer-paper': {
          width: drawerWidth,
          boxSizing: 'border-box'
        },
      }}
    >
      {drawerContent}
    </Drawer>
  );
};

export default SideNavbar;