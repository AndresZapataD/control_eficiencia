import React from "react";
import { Box } from "@mui/material";
import SideNavbar from "../components/SideNavbar";

const DashboardLayout = ({ children }) => {
  return (
    <Box sx={{ display: "flex" }}>
      
      <SideNavbar />

      <Box sx={{ flexGrow: 1, p: 3 }}>
        {children}
      </Box>

    </Box>
  );
};

export default DashboardLayout;