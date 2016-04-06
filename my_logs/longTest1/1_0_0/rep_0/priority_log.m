
% 2015-10-17 01:03:38

% my_logs\longTest1\1_0_0\rep_0\priority_log.m
scheduling_duration_us = 901;

% schedule
schedule_f_t_n(:,:,1) = [6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 4; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 24; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0];
vioDl = [0, 0];
vioNon = [0, 102];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 5, 5, 5, 5, 5, 5, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [3600, 0];
vioLcy = [12800, 0];
vioJit = [3200, 0];
cost_vio = 216212;
cost_switches = 0;
cost_ch = 868;
costTotal = 217080;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[10]6	|6	|6	|6	|6	|6	|4	|	|	|	|[20]	|	|	|	|	|
% F1	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|24	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
