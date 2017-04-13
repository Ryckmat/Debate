\ProvidesClass{Format_page}

\LoadClass[a4paper,11pt,oneside]{article}

%\RequirePackage{longtable}%

\RequirePackage{amsmath}
\RequirePackage[noblocks]{authblk}
\RequirePackage{natbib}
\RequirePackage{hyperref} 
\RequirePackage{amssymb}
\RequirePackage{graphicx}
\RequirePackage[latin1]{inputenc} 
\RequirePackage[T1]{fontenc} 

%  ****************************************
%  *            MACROS               *
%  ****************************************


\def\acknowledgments{\vskip 5.8mm plus 1mm minus 1mm}
\let\acknowledgements=\acknowledgments                  % second spelling

%  ****************************************
%  *            PAGE LAYOUT               *
%  ****************************************

% Page size, spacing parameters, etc. 

\RequirePackage{fullpage}
\RequirePackage{fancyhdr}

\pagestyle{fancy}
\headheight=.3in

\rhead[]{}
\lhead[Title]{Title}
\cfoot[]{}
\rfoot[\thepage]{\thepage}

\renewcommand{\headrulewidth}{0.5pt}
\renewcommand{\footrulewidth}{0.5pt}
