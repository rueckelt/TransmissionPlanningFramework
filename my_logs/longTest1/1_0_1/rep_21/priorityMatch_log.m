
% 2015-10-17 01:04:32

% my_logs\longTest1\1_0_1\rep_21\priorityMatch_log.m
scheduling_duration_us = 3285;

% schedule
schedule_f_t_n(:,:,1) = [6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 6, 0; 4, 0; 0, 0; 0, 0; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 0, 6; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];
schedule_f_t_n(:,:,2) = [0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 25; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0; 0, 0];

% cost function results
vioSt = [0, 0];
vioDl = [0, 225];
vioNon = [0, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 5, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [1600, 0];
vioLcy = [22736, 0];
vioJit = [14854, 0];
cost_vio = 315545;
cost_switches = 200;
cost_ch = 781;
costTotal = 316526;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|6	|6	|4	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|6	|6	|6	|6	|6	|6	|6	|	|[20]	|	|	|	|	|
% F1	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|25	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
